package kz.exampleandroid.tom.hw_fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import kz.exampleandroid.tom.hw_fragments.adapters.ProductsRecyclerAdapter;
import kz.exampleandroid.tom.hw_fragments.models.Product;



public class MainActivity extends AppCompatActivity {
    List<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

          initialProducts();




        Fragment itemDescFragment =  getSupportFragmentManager().findFragmentById(R.id.fragment_item_description);


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.fp_products_rv);

        ProductsRecyclerAdapter productsRecyclerAdapter =
                new ProductsRecyclerAdapter(products, getApplicationContext(), itemDescFragment);
        recyclerView.setAdapter(productsRecyclerAdapter);
    }

    private void initialProducts() {
        products = new ArrayList<>();
        products.add(new Product("Good 1", "Товар категории А, является товар для продвинутых пользователей.", 5000, 1));
        products.add(new Product("Good 2", "Товар категории А, является товар для практичных пользователей.", 2500, 2));
        products.add(new Product("Good 3", "Товар категории А, является товар для пользователей ценищих дизайн и современность.", 3500, 3));
    }

    private void initialFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.ma_container, new ProductFragment());
        transaction.add(R.id.ma_container, new ItemDescriptionFragent());
        transaction.commit();
    }


}
