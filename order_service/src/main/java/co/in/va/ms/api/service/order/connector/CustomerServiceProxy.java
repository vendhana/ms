package co.in.va.ms.api.service.order.connector;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerServiceProxy {

        RestTemplate restTemplate = new RestTemplate();
        @Value("${customer_service.url}")
        private String url;

        public List<Integer> getCustomersIdByAge(Integer toAge) {
                final HttpHeaders headers = new HttpHeaders();
                headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
                Map<String, Integer> map = new HashMap<>();
                map.put("toAge", toAge);
                HttpEntity<?> requestEntity = new HttpEntity<>(headers);
                HttpEntity<List<Integer>> responseEntity = restTemplate.exchange(url + "/customer/age/{toAge}",
                                HttpMethod.GET, requestEntity, new ParameterizedTypeReference<List<Integer>>() {
                                }, map);
                return responseEntity.getBody();

        }

        public List<Integer> getCustomersIdByAge(Integer toAge, Integer fromAge) {
                final HttpHeaders headers = new HttpHeaders();
                headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
                Map<String, Integer> map = new HashMap<>();
                map.put("toAge", toAge);
                map.put("fromAge", fromAge);
                HttpEntity<?> requestEntity = new HttpEntity<>(headers);
                HttpEntity<List<Integer>> responseEntity = restTemplate.exchange(
                                url + "/customer/age/{toAge}/{fromAge}", HttpMethod.GET, requestEntity,
                                new ParameterizedTypeReference<List<Integer>>() {
                                }, map);
                return responseEntity.getBody();
        }
}
