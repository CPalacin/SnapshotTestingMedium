import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.Manifest.permission.WRITE_EXTERNAL_STORAGE
import android.content.res.Resources
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.GrantPermissionRule
import com.carlos.snapshottestingmedium.R
import com.facebook.testing.screenshot.Screenshot
import com.facebook.testing.screenshot.ViewHelpers
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class LayoutSnapshotTests(val layout: Int) {
    @Rule @JvmField
    var runtimePermissionRule = GrantPermissionRule.grant(WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE)
    val widthPixels = Resources.getSystem().displayMetrics.widthPixels
    val targetContext = InstrumentationRegistry.getInstrumentation().targetContext

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name="Screenshot tests for {1}")
        fun data() = listOf(R.layout.user_card)
    }

    @Test
    @Throws(Throwable::class)
    fun testSnapshot() {
        val view = LayoutInflater.from(targetContext).inflate(layout, null, false) as FrameLayout
        System.out.println("View class: " + view.javaClass.simpleName)
        ViewHelpers.setupView(view).setExactWidthPx(widthPixels).layout()
        Screenshot.snap(view).setName(layout.toString()).record()
    }
}