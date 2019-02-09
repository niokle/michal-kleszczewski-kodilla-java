package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    ProductDao productDao;
    @Autowired
    ItemDao itemDao;
    @Autowired
    InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave() {
        //given
        Product product1 = new Product("produkt 1");
        Product product2 = new Product("produkt 2");
        Product product3 = new Product("produkt 3");
        Item item1 = new Item(product1, new BigDecimal(1), 1, new BigDecimal(1));
        Item item2 = new Item(product2, new BigDecimal(2), 2, new BigDecimal(2));
        Item item3 = new Item(product3, new BigDecimal(3), 3, new BigDecimal(3));
        Item item4 = new Item(product1, new BigDecimal(4), 4, new BigDecimal(4));
        Item item5 = new Item(product3, new BigDecimal(5), 5, new BigDecimal(5));
        List<Item> items1 = new ArrayList<>();
        items1.add(item1);
        items1.add(item3);
        items1.add(item5);
        Invoice invoice1 = new Invoice("111111", items1);
        List<Item> items2 = new ArrayList<>();
        items2.add(item2);
        items2.add(item4);
        Invoice invoice2 = new Invoice("222222", items2);

        //when
        productDao.save(product1);
        int product1_id = product1.getId();
        productDao.save(product2);
        int product2_id = product2.getId();
        productDao.save(product3);
        int product3_id = product3.getId();

        invoiceDao.save(invoice1);
        int invoice1_id = invoice1.getId();
        List<Item> itemsInvoice1 = invoice1.getItems();
        invoiceDao.save(invoice2);
        int invoice2_id = invoice2.getId();
        List<Item> itemsInvoice2 = invoice2.getItems();

        int nuberOfItemsForInvoice1 = itemDao.findByInvoice(invoice1).size();
        int nuberOfItemsForInvoice2 = itemDao.findByInvoice(invoice2).size();

        //then
        //Assert.assertEquals(3, nuberOfItemsForInvoice1);
        //Assert.assertEquals(2, nuberOfItemsForInvoice2);

        //cleanUp
        /*
        try {
            invoiceDao.delete(invoice1_id);
            invoiceDao.delete(invoice2_id);
            itemsInvoice1.stream()
                    .map(item -> item.getId())
                    .forEach(itemDao::delete);
            itemsInvoice2.stream()
                    .map(item -> item.getId())
                    .forEach(itemDao::delete);
            productDao.delete(product1_id);
            productDao.delete(product2_id);
            productDao.delete(product3_id);
        } catch (Exception e) {

        }
        */
    }
}