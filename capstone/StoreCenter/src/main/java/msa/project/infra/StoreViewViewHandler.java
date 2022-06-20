package msa.project.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import msa.project.config.kafka.KafkaProcessor;
import msa.project.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class StoreViewViewHandler {

    @Autowired
    private StoreViewRepository storeViewRepository;
    // keep

}
