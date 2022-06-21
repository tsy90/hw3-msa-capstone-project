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
    DeliveryRepository deliveryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverOrderApproved_StartDelivery(
        @Payload OrderApproved orderApproved
    ) {
        if (!orderApproved.validate()) return;
        OrderApproved event = orderApproved;
        System.out.println(
            "\n\n##### listener StartDelivery : " +
            orderApproved.toJson() +
            "\n\n"
        );

        // Sample Logic //
        Delivery.startDelivery(event);
    }
    // keep

}
