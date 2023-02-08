import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.apitesting.databinding.PostItemBinding
import com.example.apitesting.model.PostResponse
//import com.example.ktorsampleapp.databinding.PostItemBinding
//import com.example.ktorsampleapp.model.remote.Post

/**
 * Created by Taha Ben Ashur (https://github.com/tahaak67) on 07,Feb,2023
 */
class PostAdapter : ListAdapter<PostResponse, RecyclerView.ViewHolder>(DIFF_CALLBACK){
    companion object{
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<PostResponse>() {

            override fun areItemsTheSame(oldItem: PostResponse, newItem: PostResponse): Boolean {
             //   return oldItem.id == newItem.id
                return oldItem.place_id == newItem.place_id
            }

            override fun areContentsTheSame(oldItem: PostResponse, newItem: PostResponse): Boolean {
//                return oldItem.title == newItem.title || oldItem.content == newItem.content ||
//                        oldItem.picture == newItem.picture
                return oldItem.osm_type== newItem.osm_type || oldItem.licence== newItem.licence
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RecyclerView.ViewHolder {
        val  binding: PostItemBinding =
            PostItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder){
            val item = getItem(position)
            holder.bind(item)
        }
    }


    inner class ViewHolder(val itemBinding: PostItemBinding):
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(item: PostResponse){
            itemBinding.apply {
                tvTitle.text = item.osm_type
                tvContent.text=item.licence+item.category+item.display_name
                ivPicture.load("https://picsum.photos/700/700")
            }
        }
    }
}