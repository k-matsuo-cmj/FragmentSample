package jp.co.cybermissions.itspj.android.fragmentsample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MenuThanksFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MenuThanksFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //フラグメントで表示する画面をXMLファイルからインフレートする。
        val view = inflater.inflate(R.layout.fragment_menu_thanks, container, false)
        //所属アクティビティからインテントを取得。
        val intent = activity?.intent
        //インテントから引き継ぎデータをまとめたもの(Bundleオブジェクト)を取得。
        val extras = intent?.extras
        //定食名と金額を取得。
        val menuName = extras?.getString("menuName")
        val menuPrice = extras?.getString("menuPrice")
        //定食名と金額を表示させるTextViewを取得。
        val tvMenuName = view.findViewById<TextView>(R.id.tvMenuName)
        val tvMenuPrice = view.findViewById<TextView>(R.id.tvMenuPrice)
        //TextViewに定食名と金額を表示。
        tvMenuName.text = menuName
        tvMenuPrice.text = menuPrice

        //戻るボタンを取得。
        val btBackButton = view.findViewById<Button>(R.id.btBackButton)
        //戻るボタンにリスナを登録。
        btBackButton.setOnClickListener(ButtonClickListener())

        //インフレートされた画面を戻り値として返す。
        return view
    }
    /**
     * ボタンが押されたときの処理が記述されたメンバクラス。
     */
    private inner class ButtonClickListener : View.OnClickListener {
        override fun onClick(view: View) {
            //自分が所属するアクティビティを終了。
            activity?.finish()
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MenuThanksFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MenuThanksFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}