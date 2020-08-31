package ar.edu.ues21.algarrobo.admissioneventservice.client.admissionapi;

import java.util.concurrent.TimeUnit;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ar.edu.ues21.oauth.retrofit.autoconfigure.auth.AuthInterceptorFactory;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;


@Configuration
public class AdmissionClientConfig {

    private static final String SERVICE_NAME = "ADMISSION_API_SERVICE";
    private static final String READ_SCOPE = "admissionApi:read";

   
    @Value("${admission-api-service.base-url}")
    private String admissionServiceUrl;

    @Autowired
    private ObjectMapper objectMapper;

    // TODO: check if is necessary use auth factory
    @Autowired
    private AuthInterceptorFactory authInterceptorFactory;

   
    @Bean
    AdmissionClient producerClient() {
        final HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        final OkHttpClient.Builder builder = new OkHttpClient.Builder().readTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor);
        builder.addInterceptor(authInterceptorFactory.newBuilder().withServiceName(SERVICE_NAME)
                .withScope(READ_SCOPE).build());
        final OkHttpClient client = builder.build();
        final Retrofit retrofit = new Retrofit.Builder().baseUrl(admissionServiceUrl).client(client)
            .addConverterFactory(JacksonConverterFactory.create(objectMapper)).build();

        return retrofit.create(AdmissionClient.class);
    }
}