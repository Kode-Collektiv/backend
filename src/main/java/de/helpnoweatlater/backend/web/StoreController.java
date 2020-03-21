package de.helpnoweatlater.backend.web;

import de.helpnoweatlater.backend.domain.Store;
import de.helpnoweatlater.backend.service.StoreService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("/stores")
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping
    public Collection<Store> retrieveAll(){
        return storeService.retrieveAll();
    }

    @GetMapping("/{id}")
    public Store retrieveById(@PathVariable final UUID id){
        return storeService.retrieveById(id);
    }

    @PostMapping
    public Store create(@RequestBody Store store){
        return storeService.create(store);
    }

    @PutMapping("/{uuid}")
    public Store update(@RequestBody Store store, @PathVariable final UUID uuid){
        return storeService.update(store, uuid);
    }



}
