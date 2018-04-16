package araikovichinc.celladapterexample

import android.content.Context
import android.media.Image
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import araikovichinc.celladapterexample.R.id.deleteComment
import org.w3c.dom.Text

/**
 * Created by Tigran on 16.04.2018.
 */
class SimpleRecyclerAdapter(val context : Context) : RecyclerView.Adapter<SimpleRecyclerAdapter.SimpleViewHolder>() {

    val commentsList: ArrayList<Comment> = ArrayList()


    override fun getItemCount() = commentsList.size

    override fun onBindViewHolder(holder: SimpleViewHolder?, position: Int) {
        holder!!.name.text = commentsList[position].name
        holder!!.title.text = commentsList[position].title
        holder!!.text.text = commentsList[position].text
        holder!!.time.text = commentsList[position].time
    }


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): SimpleViewHolder {
        val v = LayoutInflater.from(parent!!.context).inflate(R.layout.recycler_item, parent, false)
        return SimpleViewHolder(v)
    }

    fun loadCommtents(comments: ArrayList<Comment>){
        commentsList.clear()
        commentsList.addAll(comments)
        notifyDataSetChanged()
    }


    inner class SimpleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        lateinit var deleteCommentBtn: ImageView
        lateinit var profileImage: ImageView
        lateinit var title: TextView
        lateinit var name: TextView
        lateinit var text: TextView
        lateinit var time: TextView

        init {
            deleteCommentBtn = itemView.findViewById(R.id.deleteComment)
            profileImage = itemView.findViewById(R.id.imgComment)
            title = itemView.findViewById(R.id.titleComment)
            name = itemView.findViewById(R.id.nameComment)
            text = itemView.findViewById(R.id.textComment)
            time = itemView.findViewById(R.id.timeComment)
        }
    }
}