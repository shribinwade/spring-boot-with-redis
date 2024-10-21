package com.sb_redis_example.rest;

import com.sb_redis_example.binding.Country;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping(value="/api")
public class CountryRestController {
    private HashOperations<String, Integer, Country> opsForHash = null;
    public CountryRestController(RedisTemplate<String, Country> rt){
        this.opsForHash = rt.opsForHash();
    }

    @PostMapping("/country")
    public String addCountry (@RequestBody Country country){
        opsForHash.put("COUNTRIES",country.getSno(), country);
        return "Country added";
    }

    @GetMapping("/countries")
    public Collection<Country> getCountries(){

        Map<Integer, Country> entries = opsForHash.entries("COUNTRIES");
        Collection<Country> values = entries.values();
        return values;

    }
}
