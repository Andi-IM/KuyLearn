package live.andiirham.kuylearn.hakkan

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.github.appintro.AppIntro
import com.github.appintro.AppIntroFragment
import com.github.appintro.model.SliderPagerBuilder
import live.andiirham.kuylearn.R

class WelcomeActivity : AppIntro() {
    // private lateinit var manager: PreferencesManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // manager = PreferencesManager(this)
        showIntroSlides()
    }

    private fun showIntroSlides() {
        // manager.setFirstRun()
        val pageOne = SliderPagerBuilder()
            .title(getString(R.string.welcome_title_1))
            .description(getString(R.string.welcome_description_1))
            .titleColor(Color.parseColor("#000000"))
            .descriptionColor(Color.parseColor("#000000"))
            .titleTypefaceFontRes(R.font.poppins_semibold)
            .descriptionTypefaceFontRes(R.font.poppins)
            .imageDrawable(R.drawable.ic_scene2)
            .backgroundDrawable(R.drawable.ic_scene)
            .build()

        val pageTwo = SliderPagerBuilder()
            .title(getString(R.string.welcome_title_2))
            .description(getString(R.string.welcome_description_2))
            .titleColor(Color.parseColor("#000000"))
            .descriptionColor(Color.parseColor("#000000"))
            .titleTypefaceFontRes(R.font.poppins_semibold)
            .descriptionTypefaceFontRes(R.font.poppins)
            .imageDrawable(R.drawable.ic_asset3)
            .backgroundDrawable(R.drawable.ic_scene)
            .build()

        val pageThree = SliderPagerBuilder()
            .title(getString(R.string.welcome_title_3))
            .description(getString(R.string.welcome_description_3))
            .titleColor(Color.parseColor("#000000"))
            .descriptionColor(Color.parseColor("#000000"))
            .titleTypefaceFontRes(R.font.poppins_semibold)
            .descriptionTypefaceFontRes(R.font.poppins)
            .imageDrawable(R.drawable.ic_asset4)
            .backgroundDrawable(R.drawable.ic_scene)
            .build()

        val pageFour = SliderPagerBuilder()
            .title(getString(R.string.welcome_title_4))
            .description(getString(R.string.welcome_description_4))
            .titleColor(Color.parseColor("#000000"))
            .descriptionColor(Color.parseColor("#000000"))
            .titleTypefaceFontRes(R.font.poppins_semibold)
            .descriptionTypefaceFontRes(R.font.poppins)
            .imageDrawable(R.drawable.ic_asset5)
            .backgroundDrawable(R.drawable.ic_scene)
            .build()

        addSlide(AppIntroFragment.newInstance(pageOne))
        addSlide(AppIntroFragment.newInstance(pageTwo))
        addSlide(AppIntroFragment.newInstance(pageThree))
        addSlide(AppIntroFragment.newInstance(pageFour))

        isWizardMode = true
        setBarColor(Color.parseColor("#5DCBD6"))
        supportActionBar?.hide()
        setImmersiveMode()
    }

    private fun goToMain() {
        startActivity(Intent(this, MainActivity::class.java))
    }

    override fun onSkipPressed(currentFragment: Fragment?) {
        super.onSkipPressed(currentFragment)
        goToMain()
    }

    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)
        goToMain()
    }

    override fun onSlideChanged(oldFragment: Fragment?, newFragment: Fragment?) {
        super.onSlideChanged(oldFragment, newFragment)
        Log.d("Hello", "Changed")
    }
}