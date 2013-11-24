package com.example.CatalogSample;

/**
 * Created with IntelliJ IDEA.
 * User: Павел
 * Date: 22.11.13
 * Time: 15:45
 * To change this template use File | Settings | File Templates.
 */
public class ListData {
    String title;       //Название товара
    int price;          //Цена товара
    String url; //ссылка для загрузки
    int image;       //Ссылка на изображение
    String discribe; // HTML описание товара

    ListData(String _title, int _price, int _image, String _discribe, String _url) {
        title = _title;

        price = _price;
        image = _image;
        discribe = _discribe;
        url = _url;
    }
}
