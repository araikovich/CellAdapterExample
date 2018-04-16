package araikovichinc.celladapterexample

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_simple_recycler.*

/**
 * Created by Tigran on 16.04.2018.
 */
class SimpleAdapterFragment : Fragment() {

    private lateinit var simpleRecycler: RecyclerView

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater!!.inflate(R.layout.fragment_simple_recycler, container, false)
        simpleRecycler = v.findViewById(R.id.simpleRecycler)
        simpleRecycler.layoutManager = LinearLayoutManager(context)
        val adapter = SimpleRecyclerAdapter(context.applicationContext)
        val comments = ArrayList<Comment>()
        for (i in 1..10){
            comments.add(Comment("ttt", "12:43", "Tigr", "Title", "The music and the background in the following video are not free to use, if you'd like to use the music in this video, please contact the artist."))
        }
        adapter.loadCommtents(comments)
        simpleRecycler.adapter = adapter
        return v
    }
}