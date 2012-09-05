package se.mbrock.gandul.conf;

import com.mongodb.Mongo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@Configuration
public class SpringMongoConfiguration extends AbstractMongoConfiguration {
    @Override
    public String getDatabaseName() {
        return "gandul";
    }

    @Override
    public @Bean Mongo mongo() throws Exception {
        return new Mongo("127.0.0.1");
    }
}
