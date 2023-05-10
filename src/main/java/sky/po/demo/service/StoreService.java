package sky.po.demo.service;

import org.springframework.stereotype.Service;
import sky.po.demo.component.Basket;
import sky.po.demo.model.Item;
import sky.po.demo.repository.StoreRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

    @Service
    public class StoreService {

        private final Basket basket;
        private final StoreRepository storeRepository;

        public StoreService(Basket basket, StoreRepository storeRepository) {
            this.basket = basket;
            this.storeRepository = storeRepository;
        }

        public void add(Set<Integer> ids){
            basket.add(ids);
        }

        public List<Item> get(){
            return basket.get(). stream()
                    .map(id -> storeRepository.get(id))
                    .collect(Collectors.toList());
        }

    }


