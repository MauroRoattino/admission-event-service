package ar.edu.ues21.algarrobo.admissioneventservice.client.nggBatchJobsApi;


import ar.edu.ues21.algarrobo.admissioneventservice.model.kafka.CallbackRequest;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.PUT;

public interface NggBatchJobsClient {

    @PUT("v1/jobs/error")
    Call<Void> sendCallback(@Body CallbackRequest callbackRequest);
}
