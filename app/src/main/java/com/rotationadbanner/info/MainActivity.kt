package com.rotationadbanner.info

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.rotationadbanner.info.banner.Ad
import com.rotationadbanner.info.banner.Banner
import com.rotationadbanner.info.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private var banner: Banner<Ad>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        banner = findViewById(R.id.banner)

        initAds(data())


        /** onAdClicked **/
        banner!!.setOnItemClickListener(object : Banner.OnItemClickListener<Ad> {
            override fun onAdClicked(position: Int, item: Ad) {
                Toast.makeText(this@MainActivity, "position = $position", Toast.LENGTH_SHORT).show()
            }
        })


        /** onAdBindListener **/
        banner!!.setOnItemBindListener(object : Banner.OnItemBindListener<Ad> {
            override fun onAdBind(position: Int, item: Ad, view: ImageView) {
                banner!!.setAdToImage(this@MainActivity,item,view)
            }
        })



    }


    private fun initAds(list: List<Ad>){
        banner!!.setBannerData(list)
    }


    private fun data(): ArrayList<Ad> {
        val list = ArrayList<Ad>()
        list.add(Ad("https://images.unsplash.com/photo-1597431783670-205a592f954e?crop=entropy&cs=tinysrgb&fit=crop&fm=jpg&h=800&ixid=MnwxfDB8MXxyYW5kb218MHx8fHx8fHx8MTY1MDAzODU4MA&ixlib=rb-1.2.1&q=80&utm_campaign=api-credit&utm_medium=referral&utm_source=unsplash_source&w=1900"))
        list.add(Ad("https://picsum.photos/200/300.jpg"))
        list.add(Ad("https://firebasestorage.googleapis.com/v0/b/chat-app-ad893.appspot.com/o/Chats%2F3428a749-a801-49e0-9d5d-096f209c79b32965?alt=media&token=3e07e8a6-b1c9-4280-84c0-3d09d73bf43a"))
        list.add(Ad("http://desk.fd.zol-img.com.cn/t_s1024x768c5/g5/M00/0F/0A/ChMkJleZ8-iIBbFBAAVrdxItOlQAAT76QAFx7oABWuP846.jpg"))
        list.add(Ad("http://desk.fd.zol-img.com.cn/t_s1024x768c5/g5/M00/0B/04/ChMkJ1bG5kyIcwkXAAsM0s9DJzoAAKsAwJB9ncACwzq207.jpg"))
        return list
    }


    override fun onResume() {
        super.onResume()
        banner!!.setPlaying(true)
    }

    override fun onPause() {
        super.onPause()
        banner!!.setPlaying(false)
    }


}