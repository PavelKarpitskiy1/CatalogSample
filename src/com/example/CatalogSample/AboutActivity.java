package com.example.CatalogSample;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import com.example.CatalogSample.R;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.content.Intent;

public class AboutActivity extends Activity implements OnClickListener
{
    /**
     * Called when the activity is first created.
     */
    public static final String EXT_TextToShow = "text";
    public static final String EXTRA_URL = "url";
    private WebView web;

    /**
     * Called when the activity is first created.
     */
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

        //Получаем данне от деятельности MainListActivity
        Intent intent = getIntent();
        String cells = intent.getStringExtra(EXT_TextToShow);
        String url = intent.getStringExtra(EXTRA_URL);

        //Устанавливаем обработчик нажатия кнопки
        Button btnAct = (Button) findViewById(R.id.button1);
        btnAct.setOnClickListener(this);

        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress_bar);

        //Получаем доступ к WebView и загружаем туда HTML страницу
        web = (WebView) findViewById(R.id.webView1);
        web.setWebViewClient(new WebViewClient()
        {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon)
            {
                super.onPageStarted(view, url, favicon);

                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url)
            {
                super.onPageFinished(view, url);

                progressBar.setVisibility(View.INVISIBLE);
            }
        });
        web.loadDataWithBaseURL("",
                "<!Doctype html><html><head><meta charset=utf-8></head>"
                        + "<body> " + cells + " </body></html> ", "text/html", "utf-8", "");

        web.loadUrl(url);
    }

    public void onClick(View v)
    {
        finish();
    }
}
