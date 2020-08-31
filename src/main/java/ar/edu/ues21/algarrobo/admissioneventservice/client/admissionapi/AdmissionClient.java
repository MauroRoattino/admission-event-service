package ar.edu.ues21.algarrobo.admissioneventservice.client.admissionapi;



import ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment.Location;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AdmissionClient {

        @GET("v1/locations/{id}")
        Call<Location> getLocation( @Path("id") final Long id);
}