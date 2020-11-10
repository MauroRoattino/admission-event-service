package ar.edu.ues21.algarrobo.admissioneventservice.client.nggBatchJobsApi;

import ar.edu.ues21.oauth.retrofit.autoconfigure.auth.AuthInterceptorFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.concurrent.TimeUnit;

@Configuration
public class NggBatchJobsClientConfig {

    private static final String SERVICE_NAME = "NGG_BATCH_JOBS_SERVICE";
    private static final String WRITE_SCOPE = "callback-batch:write";

    @Value("${ngg-batch-jobs.base-url}")
    private String nggBatchJobsServiceUrl;

    @Bean
    NggBatchJobsClient nggBatchJobsClient(ObjectMapper objectMapper, AuthInterceptorFactory authInterceptorFactory) {
        final HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        final OkHttpClient.Builder builder = new OkHttpClient.Builder().readTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor);
        builder.addInterceptor(authInterceptorFactory.newBuilder().withServiceName(SERVICE_NAME)
                .withScope(WRITE_SCOPE).build());
        final OkHttpClient client = builder.build();
        final Retrofit retrofit = new Retrofit.Builder().baseUrl(nggBatchJobsServiceUrl).client(client)
                .addConverterFactory(JacksonConverterFactory.create(objectMapper)).build();

        return retrofit.create(NggBatchJobsClient.class);
    }
}
