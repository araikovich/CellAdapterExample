package araikovichinc.celladapterexample

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import io.techery.celladapter.CellAdapter

/**
 * Created by Tigran on 16.04.2018.
 */
class CellRecyclerFragment : Fragment() {

    lateinit var cellRecycler: RecyclerView

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater!!.inflate(R.layout.fragment_cell_adapter, container, false)
        cellRecycler = v.findViewById(R.id.cell_recycler)
        cellRecycler.layoutManager = LinearLayoutManager(context)
        val cellAdapter = CellAdapter<Comment>(context)
        cellAdapter.registerCell(Comment::class.java, CommentCell::class.java, object : CommentCell.Listener {
            override fun onPress(comment: Comment) {
            }

            override fun onCellClicked(p0: Comment?) {
                Toast.makeText(context.applicationContext, "click", Toast.LENGTH_SHORT).show()
            }

        } )
        cellRecycler.adapter = cellAdapter
        val comments = ArrayList<Comment>()
        for (i in 1..10){
            comments.add(Comment("ttt", "12:43", "Tigr", "Title", "The music and the background in the following video are not free to use, if you'd like to use the music in this video, please contact the artist."))
        }
        cellAdapter.items = comments
        cellAdapter.notifyDataSetChanged()

        return  v
    }
}