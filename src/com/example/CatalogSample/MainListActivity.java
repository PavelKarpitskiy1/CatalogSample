package com.example.CatalogSample;

import android.app.Activity;
import android.content.Intent;
import android.widget.AdapterView;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.view.View;

import java.util.ArrayList;

public class MainListActivity extends Activity implements AdapterView.OnItemClickListener {
    /**
     * Called when the activity is first created.
     */
    private TextView myText;
    private ArrayList<ListData> catalog;
    String[] names = {"iPad черный", "iPad белый", "iPad-чехол",
            "iPad-сумка", "iPad-крышка", "iPad-клавиатура"};

    String[] desc = {"<h1>iPad черный</h1> <center><img src=\"pic03.jpg\"></center><p> Черный iPad! Это<b> очень здорово</b>!!!</p>",
            "<h1>iPad белый</h1>", "<h1>iPad-чехол</h1>",
            "<h1>iPad-сумка</h1>", "<h1>iPad-крышка</h1>",
            "<h1>iPad-клавиатура</h1>"};

    String[] urls = {"http://svyaznoy.ru/catalog/notebook/7063/1314203", "http://nsk-digital.ru/product/apple-ipad-3-16-gb-wi-fi4g-belyj/",
            "http://iphone-nsk.ru/aksessuary/aksessuary-dlya-ipad/chekhly.html",
            "http://sotmarket.ru/product/cover-apple-ipad-4-cooler-master-afrino-folio.html",
            "http://nsk-digital.ru/product/remont-zadnyaya-krishka-ipad-wifi-64gb/",
            "http://nsk-digital.ru/product/chehol-klaviatura-zagg-zaggfolio-korichnevyj-dlja-ipad-2-ipad-3-ipad-4/"};

    int[] cost = {30000, 22900, 2500, 690, 2000, 5900};
    int[] img = {R.drawable.pic01, R.drawable.pic02, R.drawable.pic03,
            R.drawable.pic04, R.drawable.pic05, R.drawable.pic06};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        myText = (TextView) findViewById(R.id.titleMain);

//Создаем массив объектов ListData и заполняем их данными
        catalog = new ArrayList<ListData>();
        for (int i = 1; i <= 6; i++) {
            catalog.add(new ListData(names[i - 1], cost[i - 1], img[i - 1], desc[i - 1], urls[i - 1]));
        }

        //Создаем адаптер данных
        CatalogAdapter catAdapter;
        catAdapter = new CatalogAdapter(this, catalog);

        ListView listView = (ListView) findViewById(android.R.id.list);
        listView.setAdapter(catAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, AboutActivity.class);
        intent.putExtra(AboutActivity.EXT_TextToShow, catalog.get(position).discribe);
        intent.putExtra(AboutActivity.EXTRA_URL, catalog.get(position).url);
        startActivity(intent);
    }
}



