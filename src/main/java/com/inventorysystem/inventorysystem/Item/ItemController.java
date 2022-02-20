package com.inventorysystem.inventorysystem.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/items", produces = MediaType.APPLICATION_JSON_VALUE)
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping(path = "/getByUPC")
    public Optional<Item> getByUPC(@RequestBody Item item) {
        Optional<Item> found = itemService.getItemByUPC(item.getUPC());
        return found;
    }

    @GetMapping(path = "getByID")
    public Optional<Item> getByID(@RequestBody Item item) {
        Optional<Item> found = itemService.getItemByID(item.getID());
        return found;
    }

    @GetMapping(path = "/getAll")
    public List<Item> getItems() {
        return itemService.getItems();
    }

    /**
     * Gets all the Items based on the provided list of upcs.
     * Main function is for mapping the item information together with the location and location information.
     * The format of the request body for the upcs should look like ["123456","543210","987654", etc]
     * Do not use the standard format of "upcs": ["123456","543210", "987654", etc].
     * @param upcs
     * @return
     */
    @GetMapping(path = "/getItems")
    public Optional<List<Item>> getByUPCS(@RequestBody List<String> upcs) {
        return itemService.getItemsByUPCS(upcs);
    }

    @PostMapping(path = "/create")
    public void createNewItem(@RequestBody Item item) {
        itemService.createNewItem(item);
    }

}