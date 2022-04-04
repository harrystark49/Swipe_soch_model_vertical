package com.example.swipe.example

import android.content.Context
import android.net.Uri
import android.view.View
import android.widget.ProgressBar
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import kotlinx.android.synthetic.main.each_item.view.*

class ViewHolder1(var context: Context,view:View):RecycledPagerAdapter.ViewHolder(view) {
   lateinit var viewPager: TestViewPager


    fun redner(url:String){
        var playerView: PlayerView
        var player: SimpleExoPlayer
        playerView=itemView.playerView
        player=SimpleExoPlayer.Builder(context).build()
        playerView.player=player

      var s=  DefaultDataSourceFactory(context,Util.getUserAgent(context,"harry"),DefaultBandwidthMeter())
        val dataSourceFactory=s
        var mediaSource= ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(Uri.parse(url))
        player.prepare(mediaSource)
        player.playWhenReady=true
    }

    override fun onDestroy() {

    }


}