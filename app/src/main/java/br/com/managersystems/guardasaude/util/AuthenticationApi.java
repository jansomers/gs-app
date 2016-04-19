package br.com.managersystems.guardasaude.util;

import br.com.managersystems.guardasaude.login.domain.WebResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AuthenticationApi {

    @GET("mobile/authenticateUser")
    Call<WebResponse> authenticateUser(
            @Query("LDWI") String username,
            @Query("GKSP") String password);
}
