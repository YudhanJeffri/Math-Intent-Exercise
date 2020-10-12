package com.cobacobaaja.kk4a.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cobacobaaja.kk4a.R
import com.cobacobaaja.kk4a.model.Hero

class HeroAdapter internal constructor(private val context: Context) : BaseAdapter() {
    internal var heroes = arrayListOf<Hero>()
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var itemView = p1
        if (itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.item_hero, p2, false)
        }
        val viewHolder = ViewHolder(itemView as View)
        val hero = getItem(p0) as Hero
        viewHolder.bind(hero)
        return itemView
    }

    override fun getItem(p0: Int): Any = heroes[p0]

    override fun getItemId(p0: Int): Long = p0.toLong()

    override fun getCount(): Int = heroes.size

    private inner class ViewHolder internal constructor(view: View) {
        private val txtName: TextView = view.findViewById(R.id.txt_name)
        private val txtDescription: TextView = view.findViewById(R.id.txt_description)
        private val imgPhoto: ImageView = view.findViewById(R.id.img_photo)
        internal fun bind(hero: Hero) {
            txtName.text = hero.name
            txtDescription.text = hero.description
            imgPhoto.setImageResource(hero.photo)
        }
    }
}

