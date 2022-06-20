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
    PayRepository payRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverOrderCanceled_CancelPay(
        @Payload OrderCanceled orderCanceled
    ) {
        if (!orderCanceled.validate()) return;
        OrderCanceled event = orderCanceled;
        System.out.println(
            "\n\n##### listener CancelPay : " + orderCanceled.toJson() + "\n\n"
        );

        // Sample Logic //
        Pay.cancelPay(event);
    }
    // keep

}
