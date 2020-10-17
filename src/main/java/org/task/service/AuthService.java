package org.task.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {
    public String getToken() {
        String link = "http://interview.agileengine.com/auth";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        Map<String, Object> map = new HashMap<>();
        map.put("apiKey", "23567b218376f79d9415");
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> response = template.postForEntity(link, entity, String.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            JSONObject jsonObject = new JSONObject(response.getBody());
            return jsonObject.getString("token");
        }
        return null;
    }
}
