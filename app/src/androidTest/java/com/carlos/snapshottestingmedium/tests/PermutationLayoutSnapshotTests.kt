import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.Manifest.permission.WRITE_EXTERNAL_STORAGE
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.GrantPermissionRule
import com.carlos.snapshottestingmedium.R
import com.carlos.snapshottestingmedium.permutations.Permutation
import com.facebook.testing.screenshot.Screenshot
import com.facebook.testing.screenshot.ViewHelpers
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

//@RunWith(Parameterized::class)
//class PermutationLayoutSnapshotTests(val layoutConfiguration: Pair<Int, List<Permutation<*>>>) {
//    @Rule @JvmField
//    var runtimePermissionRule = GrantPermissionRule.grant(WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE)
//    val widthPixels = Resources.getSystem().displayMetrics.widthPixels
//    val targetContext = InstrumentationRegistry.getInstrumentation().targetContext
//
//    companion object {
//        @JvmStatic
//        @Parameterized.Parameters(name="Screenshot tests for {1}")
//        fun data() = listOf(
//            Pair(R.layout.user_card, listOf(Permutation<>()))
//        )
//    }
//
//    @Test
//    @Throws(Throwable::class)
//    fun snapshotTest() {
//        val view = LayoutInflater.from(targetContext).inflate(layoutConfiguration.first, null, false) as FrameLayout
//        ViewHelpers.setupView(view).setExactWidthPx(widthPixels).layout()
//
//        applyPermutation(view, layoutConfiguration.second)
//    }
//
//    private fun applyPermutation(view: View, permutations: List<Permutation<*>>, position: Int = 0, permutation: String) {
//        if (permutations.size == position) {
//            Screenshot.snap(view).setName(layoutConfiguration.first.toString()+).record()
//        }
//
//        val currentPermutation = permutations[position]
//        for(i in 0 until currentPermutation.size()) {
//            currentPermutation.applyPermutation(i)
//            applyPermutation(view, permutations, position + 1)
//        }
//    }
//}