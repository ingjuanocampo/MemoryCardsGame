package juanocampo.test.memoryflipgame.view.lobby

import android.os.Bundle
import juanocampo.test.memoryflipgame.R
import juanocampo.test.memoryflipgame.view.base.activity.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, LobbyFragment.newInstance())
                .commitNow()
        }
    }

}
