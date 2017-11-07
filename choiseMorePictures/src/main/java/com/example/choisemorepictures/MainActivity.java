package com.example.choisemorepictures;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.logic.ImgFileListActivity;

import java.util.ArrayList;

/**
 * @QQ:794522712
 * @����: kir~song
 * @����: 2014-4-8
 * @��ӭ: ��ӭ���ҽ���.^_^
 * @ʹ�÷���: ��ѡ���ͼƬ�ļ����ݻ��� ImgsActivity.sendfiles�����½��л�ȡ,
 *          ֻ��Ҫ�ڸ÷�������ת����Ҫ��Ľ��漴��
 */
public class MainActivity extends Activity {

	ListView listView;
	ArrayList<String> listfile=new ArrayList<String>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listView=(ListView) findViewById(R.id.listView1);
		Bundle bundle= getIntent().getExtras();
	
		if (bundle!=null) {
			if (bundle.getStringArrayList("files")!=null) {
				listfile= bundle.getStringArrayList("files");
				listView.setVisibility(View.VISIBLE);
				ArrayAdapter<String> arryAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listfile);
				listView.setAdapter(arryAdapter);
			}
		}
		
	}

	public void chise(View v){
		Intent intent = new Intent();
		intent.setClass(this,ImgFileListActivity.class);
		startActivity(intent);
	}

	//���ֻ��������ַ���
	/* Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("image*//*");
                startActivityForResult(intent, 0);*/

	/*Intent i = new Intent(
			Intent.ACTION_PICK,// ���
			android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
	i.setType("image*//*");
	startActivityForResult(i, 0);*/
}
