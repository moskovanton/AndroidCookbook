package com.example.handbook

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_content.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    var adapter: MyAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nav_view.setNavigationItemSelectedListener (this)

        var list = ArrayList<ListItem>()

        list.addAll(fillArrays(resources.getStringArray(R.array.title1),
            resources.getStringArray(R.array.content1),
            getImageId(R.array.img1)))

        rcView.hasFixedSize()
        rcView.layoutManager = LinearLayoutManager(this)
        adapter = MyAdapter(list, this)
        rcView.adapter = adapter
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {

            R.id.id_title1 -> {
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.title1),
                    resources.getStringArray(R.array.content1),
                    getImageId(R.array.img1)))
            }
            R.id.id_title2 -> {
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.title2),
                    resources.getStringArray(R.array.content2),
                    getImageId(R.array.img2)))
            }
            R.id.id_title3 -> {
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.title3),
                    resources.getStringArray(R.array.content3),
                    getImageId(R.array.img3)))
            }
            R.id.id_title4 -> {
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.title4),
                    resources.getStringArray(R.array.content4),
                    getImageId(R.array.img4)))
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    fun fillArrays(titleArray:Array<String>,contentArray:Array<String>,imageArray:IntArray):List<ListItem> {
         var listItemArray = ArrayList<ListItem>()
        for(n in 0..titleArray.size-1){
            var listItem = ListItem(imageArray[n], titleArray[n], contentArray[n])
            listItemArray.add(listItem)
        }
            return listItemArray
    }

    fun getImageId(imageArrayId:Int):IntArray {
        var tArray:TypedArray = resources.obtainTypedArray(imageArrayId)
        val count = tArray.length()
        val ids = IntArray(count)
        for(i in ids.indices){
            ids[i] = tArray.getResourceId(i, 0)
        }
        tArray.recycle()
        return ids
    }

}