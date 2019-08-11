import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.Manifest.permission.WRITE_EXTERNAL_STORAGE
import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.GrantPermissionRule
import com.carlos.snapshottestingmedium.tests.configuration.TestConfiguration
import com.carlos.snapshottestingmedium.tests.Variation
import com.carlos.snapshottestingmedium.tests.configuration.UserCardConfiguration
import com.facebook.testing.screenshot.Screenshot
import com.facebook.testing.screenshot.ViewHelpers
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class PermutationLayoutSnapshotTests(val configuration: TestConfiguration) {
    @Rule @JvmField
    var runtimePermissionRule = GrantPermissionRule.grant(WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE)
    val widthPixels = Resources.getSystem().displayMetrics.widthPixels
    val targetContext: Context = InstrumentationRegistry.getInstrumentation().targetContext

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name="Screenshot tests for {1}")
        fun data() = listOf(
            UserCardConfiguration()
        )
    }

    @Test
    @Throws(Throwable::class)
    fun snapshotTest() {
        val view = LayoutInflater.from(targetContext).inflate(configuration.layout, null, false)
        ViewHelpers.setupView(view).setExactWidthPx(widthPixels).layout()
        val variations = configuration.variation

        applyPermutation(view, variations)
    }

    private fun applyPermutation(view: View, variations: Array<out Variation<*>>, position: Int = 0, permutation: String = "") {
        if (variations.size == position) {
            Screenshot.snap(view).setName(configuration.toString() + permutation).record()
        } else {
            val currentPermutation = variations[position]
            for (i in 0 until currentPermutation.size()) {
                currentPermutation.applyPermutation(view, i)
                applyPermutation(view, variations, position + 1, permutation + i)
            }
        }
    }
}