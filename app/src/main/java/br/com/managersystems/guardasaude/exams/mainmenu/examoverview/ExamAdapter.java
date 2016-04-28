package br.com.managersystems.guardasaude.exams.mainmenu.examoverview;


import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.managersystems.guardasaude.R;
import br.com.managersystems.guardasaude.exams.domain.Exam;
import br.com.managersystems.guardasaude.ui.fragments.ExamOverviewFragment;

public class ExamAdapter extends RecyclerView.Adapter<ExamAdapter.ExamViewHolder>{
    private LayoutInflater inflater;
    List<Exam> examList;
    Context context;
    ExamOverviewFragment examOverview;

    public ExamAdapter(Context context,List<Exam> examList,ExamOverviewFragment examOverview) {
        inflater = LayoutInflater.from(context);
        this.examList = examList;
        this.context = context;
        this.examOverview = examOverview;
    }

    @Override
    public ExamViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_examlistitem, parent, false);
        return new ExamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ExamViewHolder holder, int position) {
        final Exam current = examList.get(position);
        holder.examId.setText(current.getIdentification());
        holder.patientName.setText(toCamelCase(current.getPatient()));
        holder.clinicName.setText(current.getReportingPhysicianName());
        holder.executionDate.setText(removeHoursFromDate(current.getExecutionDate()));
        holder.statusText.setText(current.getStatus());
        if(current.getStatus().equalsIgnoreCase("Finished")){
            holder.statusImage.setImageDrawable(ContextCompat.getDrawable(examOverview.getContext(), R.drawable.ic_check_circle_36dp));
        }else{
            holder.statusImage.setImageDrawable(ContextCompat.getDrawable(examOverview.getContext(),R.drawable.ic_clock));
        }
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                examOverview.navigateToExamDetail(current);
            }
        });
    }

    @Override
    public int getItemCount() {
        return examList.size();
    }

    private String toCamelCase(String string){
        if (string==null)
            return null;

        final StringBuilder ret = new StringBuilder(string.length());

        for (final String word : string.split(" ")) {
            if (!word.isEmpty()) {
                ret.append(word.substring(0, 1).toUpperCase());
                ret.append(word.substring(1).toLowerCase());
            }
            if (!(ret.length()==string.length()))
                ret.append(" ");
        }

        return ret.toString();
    }

    private String removeHoursFromDate(String date){
        return date.substring(0, date.length() - 5);
    }

    public void addAllExams(List<Exam> exams){
        this.examList = exams;
        notifyDataSetChanged();

    }

    class ExamViewHolder extends RecyclerView.ViewHolder{
        TextView examId;
        TextView statusText;
        TextView clinicName;
        TextView patientName;
        TextView executionDate;
        CardView cardView;
        ImageView statusImage;

        public ExamViewHolder(View itemView) {
            super(itemView);
            examId = (TextView)itemView.findViewById(R.id.exam_id);
            statusText = (TextView)itemView.findViewById(R.id.status_text);
            clinicName = (TextView)itemView.findViewById(R.id.clinic_name);
            patientName = (TextView)itemView.findViewById(R.id.patient_name);
            executionDate = (TextView)itemView.findViewById(R.id.execution_date);
            cardView = (CardView)itemView.findViewById(R.id.cardView);
            statusImage = (ImageView)itemView.findViewById(R.id.status_icon);
        }
    }
}
