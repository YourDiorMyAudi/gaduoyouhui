package com.example.myandroid;

import java.util.Iterator;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button btnClick = (Button) findViewById(R.id.btnClick);
		btnClick.setOnClickListener(this);
	}

	public void onClick(View v) {
		TextView tv = (TextView) findViewById(R.id.textView1);

		Thread thread = new Thread(runnable);
		thread.start();

		//tv.setText("success");
	}
	
	Handler handler = new Handler(){
	    @Override
	    public void handleMessage(Message msg) {
	        super.handleMessage(msg);
	        Bundle data = msg.getData();
	        String val = data.getString("jw");
	        Log.i("mylog","请求结果-->" + val);
	        
	        TextView tv = (TextView) findViewById(R.id.textView1);
	        tv.setText(val);
	    }
	};

	Runnable runnable = new Runnable() {
		@Override
		public void run() {
			String url = "http://120.24.222.250:8080/gdyh/json";
			HttpClient httpClient = new DefaultHttpClient();
			HttpPost post = new HttpPost(url);
			HttpResponse response = null;
			JSONObject array = null;
			try {
				// getHttpConnectionManager().getParams().setConnectionTimeout(11);
				httpClient.getParams().setParameter(
						CoreConnectionPNames.CONNECTION_TIMEOUT, 5000);
				response = httpClient.execute(post);// 发送请求
				int statusCode = response.getStatusLine().getStatusCode();
				System.out.println("连接状态:" + statusCode);
				if (statusCode >= 200 && statusCode < 400) {// 判断请求是否成功
					HttpEntity entity = response.getEntity();
					String out = EntityUtils.toString(entity, "GBK");
					// out=Base64.encodeToString(out.getBytes("GBK")
					// ,Base64.DEFAULT);
					System.out.println("返回结果：" + out);
					array = new JSONObject(out);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("array" + array);
			Bundle bundle = new Bundle();

			Message msg = Message.obtain();
			Iterator keys = array.keys();
			try {
				bundle.putString("jw", array.getString("jw"));
				msg.setData(bundle);
				handler.sendMessage(msg);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//handler.sendMessage(new Message(array));
		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
