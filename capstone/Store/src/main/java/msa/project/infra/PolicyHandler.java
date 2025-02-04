package msa.project.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import msa.project.config.kafka.KafkaProcessor;
import msa.project.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    StoreRepository storeRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPayCanceled_CancelApprove(
        @Payload PayCanceled payCanceled
    ) {
        if (!payCanceled.validate()) return;
        PayCanceled event = payCanceled;
        System.out.println(
            "\n\n##### listener CancelApprove : " +
            payCanceled.toJson() +
            "\n\n"
        );

        // Sample Logic //
        Store.cancelApprove(event);
    }
    // keep

}
