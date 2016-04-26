package br.com.managersystems.guardasaude.exams.mainmenu.examoverview;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.managersystems.guardasaude.R;
import br.com.managersystems.guardasaude.exams.domain.Exam;

public class ExamAdapter extends RecyclerView.Adapter<ExamAdapter.ExamViewHolder> {
    private LayoutInflater inflater;
    List<Exam> examList;

    public ExamAdapter(Context context,List<Exam> examList) {
        inflater = LayoutInflater.from(context);
        this.examList = examList;
    }

    @Override
    public ExamViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_examlistitem,parent,false);
        return new ExamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ExamViewHolder holder, int position) {
        Exam current = examList.get(position);
        holder.examId.setText(current.getId().toString());
        holder.patientName.setText(current.getPatient());
        holder.clinicName.setText(current.getReportingPhysicianName());
        holder.executionDate.setText(current.getExecutionDate());
        holder.statusText.setText(current.getStatus());
    }

    @Override
    public int getItemCount() {
        return examList.size();
    }

    class ExamViewHolder extends RecyclerView.ViewHolder{
        TextView examId;
        TextView statusText;
        TextView clinicName;
        TextView patientName;
        TextView executionDate;

        public ExamViewHolder(View itemView) {
            super(itemView);
            examId = (TextView)itemView.findViewById(R.id.exam_id);
            statusText = (TextView)itemView.findViewById(R.id.status_text);
            clinicName = (TextView)itemView.findViewById(R.id.clinic_name);
            patientName = (TextView)itemView.findViewById(R.id.patient_name);
            executionDate = (TextView)itemView.findViewById(R.id.execution_date);
        }
    }
}
