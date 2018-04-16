package araikovichinc.celladapterexample

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import io.techery.celladapter.Cell
import io.techery.celladapter.Layout

/**
 * Created by Tigran on 16.04.2018.
 */

@Layout(R.layout.recycler_item)
class CommentCell(itemView: View) : Cell<Comment, CommentCell.Listener>(itemView) {

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
        deleteCommentBtn.setOnClickListener { listener.onPress(item) }
    }

    override fun syncUiWithItem() {
        title.text = item.title
        name.text = item.name
        time.text = item.time
        text.text = item.text
    }

    interface Listener : Cell.Listener<Comment>{
        fun onPress(comment: Comment)
    }

}