package com.icodeap.ecommerce.application.service;

import com.icodeap.ecommerce.domain.ItemCart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CartService {

    private List<ItemCart> itemCarts;
    private HashMap<Integer, ItemCart> itemCartHashMap;

    public CartService() {
        this.itemCartHashMap = new HashMap<>();
        this.itemCarts = new ArrayList<>();
    }

    public void addItemCart(Integer quantity, Integer idProduct, String nameProduct, BigDecimal price){
        ItemCart itemCart = itemCartHashMap.get(idProduct);
        if (itemCart != null) {
            itemCart.setQuantity(itemCart.getQuantity() + quantity);
        } else {
            itemCart = new ItemCart(idProduct, nameProduct, quantity, price);
            itemCartHashMap.put(idProduct, itemCart);
        }
        fillList();
    }

    public BigDecimal getTotalCart(){
        BigDecimal total = BigDecimal.ZERO;
        for (ItemCart itemCart : itemCarts){
            total = total.add(itemCart.getTotalPriceItem());
        }
        return total;
    }

    public void removeItemCart(Integer idProduct){
        itemCartHashMap.remove(idProduct);
        fillList();
    }

    public void removeAllItemsCart(){
        itemCartHashMap.clear();
        itemCarts.clear();
    }

    private void fillList(){
        itemCarts = new ArrayList<>(itemCartHashMap.values());
    }

    //para mirar por consola
    public List<ItemCart> getItemCarts(){
        return itemCarts;
    }

}
