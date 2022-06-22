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
public class CustomerViewViewHandler {

    @Autowired
    private CustomerViewRepository customerViewRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderPlaced_then_CREATE_1(
        @Payload OrderPlaced orderPlaced
    ) {
        try {
            if (!orderPlaced.validate()) return;

            // view 객체 생성
            CustomerView customerView = new CustomerView();
            // view 객체에 이벤트의 Value 를 set 함
            //customerView.setId(id);
            customerView.setId(Long.valueOf(orderPlaced.getOrderStatus())); // 위에 에러떠서 이걸로 변경
            customerView.setOrderStatus(
                String.valueOf(orderPlaced.getOrderStatus())
            );
            customerView.setUserId(orderPlaced.getUserId());
            // view 레파지 토리에 save
            customerViewRepository.save(customerView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderCanceled_then_UPDATE_1(
        @Payload OrderCanceled orderCanceled
    ) {
        try {
            if (!orderCanceled.validate()) return;
            // view 객체 조회

            List<CustomerView> customerViewList = customerViewRepository.findByOrderId(
                String.valueOf(orderCanceled.getId())
            );
            for (CustomerView customerView : customerViewList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                customerView.setOrderStatus(
                    String.valueOf(orderCanceled.getOrderStatus())
                );
                // view 레파지 토리에 save
                customerViewRepository.save(customerView);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPayCompleted_then_UPDATE_2(
        @Payload PayCompleted payCompleted
    ) {
        try {
            if (!payCompleted.validate()) return;
            // view 객체 조회

            List<CustomerView> customerViewList = customerViewRepository.findByPayId(
                payCompleted.getId()
            );
            for (CustomerView customerView : customerViewList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                customerView.setPayStatus(
                    Boolean.valueOf(payCompleted.getPayStatus())
                );
                // view 레파지 토리에 save
                customerViewRepository.save(customerView);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPayCanceled_then_UPDATE_3(
        @Payload PayCanceled payCanceled
    ) {
        try {
            if (!payCanceled.validate()) return;
            // view 객체 조회

            List<CustomerView> customerViewList = customerViewRepository.findByPayId(
                payCanceled.getId()
            );
            for (CustomerView customerView : customerViewList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                customerView.setPayStatus(
                    Boolean.valueOf(payCanceled.getPayStatus())
                );
                // view 레파지 토리에 save
                customerViewRepository.save(customerView);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryStarted_then_UPDATE_4(
        @Payload DeliveryStarted deliveryStarted
    ) {
        try {
            if (!deliveryStarted.validate()) return;
            // view 객체 조회

            List<CustomerView> customerViewList = customerViewRepository.findByDeliverId(
                String.valueOf(deliveryStarted.getId())
            );
            for (CustomerView customerView : customerViewList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                customerView.setDeliveryStatus(
                    deliveryStarted.getDeliveryStatus()
                );
                // view 레파지 토리에 save
                customerViewRepository.save(customerView);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderCanceled_then_DELETE_1(
        @Payload OrderCanceled orderCanceled
    ) {
        try {
            if (!orderCanceled.validate()) return;
            // view 레파지 토리에 삭제 쿼리
            customerViewRepository.deleteByOrderId(orderCanceled.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // keep

}
