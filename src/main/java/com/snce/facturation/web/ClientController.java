package com.snce.facturation.web;

import com.snce.facturation.entities.Client;
import com.snce.facturation.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/client")
@CrossOrigin("*")
public class ClientController {
    private ClientService clientService;

    @GetMapping("/all")
    public List<Client> getAll(@RequestParam("keyword") String keyword){
        return clientService.getAllClient(keyword);
    }

    @GetMapping("")
    public Page<Client> getAll(@RequestParam() int page,
                                @RequestParam() String keyword){
        return clientService.getAllClientPage(keyword,page);
    }
    @PostMapping("")
    public Client save(@RequestBody Client client){
        return clientService.save(client);
    }
    @GetMapping("/byId")
    public Optional<Client> getByClient(@RequestParam Long id){
        return clientService.getById(id);
    }
    @PutMapping("")
    public Client update(@RequestBody Client client){
        return clientService.update(client);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        clientService.delete(id);
    }
}
