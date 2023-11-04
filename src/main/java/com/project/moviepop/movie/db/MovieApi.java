package com.project.moviepop.movie.db;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MovieApi {
    public static Set<String> getMovieList() {
        HashMap<String, Object> result = new HashMap<String, Object>();
        Set<String> movieCodeSet = new HashSet<>();

        ExecutorService executorService = Executors.newFixedThreadPool(5); // 동시 요청 수

        try {
            List<Future<ResponseEntity<Map>>> futures = new ArrayList<>();

            SimpleDateFormat formatter = new SimpleDateFormat();
            formatter.applyPattern("yyyyMMdd");
            Calendar calendar = Calendar.getInstance();
            calendar.set(2023, 7, 2);

            for(int count = 1; count <= 100; count++) {
                RestTemplate restTemplate = new RestTemplate();

                HttpHeaders header = new HttpHeaders();
                HttpEntity<?> entity = new HttpEntity<>(header);
                String url = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.json";
                UriComponents uri = UriComponentsBuilder.fromHttpUrl(url+"?"+"targetDt="+formatter.format(calendar.getTime())+"&weekGb=0&"+"key=f5eef3421c602c6cb7ea224104795888").build();

                //이 한줄의 코드로 API를 호출해 MAP타입으로 전달 받는다.
                Callable<ResponseEntity<Map>> resultMap = () -> restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, Map.class);
                Future<ResponseEntity<Map>> future = executorService.submit(resultMap);
                futures.add(future);
                calendar.add(Calendar.MONTH, -1);
            }

            for(Future<ResponseEntity<Map>> future : futures) {
                ResponseEntity<Map> resultMap = future.get();
                LinkedHashMap lm = (LinkedHashMap) resultMap.getBody().get("boxOfficeResult");
                ArrayList<Map> dboxoffList = (ArrayList<Map>) lm.get("weeklyBoxOfficeList");
                for(int idx = 0; idx < dboxoffList.size(); idx++)
                    movieCodeSet.add(dboxoffList.get(idx).get("movieCd").toString());
            }
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            result.put("statusCode", e.getRawStatusCode());
            result.put("body"  , e.getStatusText());
            System.out.println(e.toString());

        } catch (Exception e) {
            result.put("statusCode", "999");
            result.put("body"  , "excpetion오류");
            System.out.println(e.toString());
        } finally {
            executorService.shutdown();
        }

        return movieCodeSet;
    }
}
