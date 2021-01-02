package live.andiirham.kuylearn.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.github.appintro.AppIntro

class WelcomeActivity : AppIntro() {
    private lateinit var manager: PreferencesManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        manager = PreferencesManager(this)
        if (manager.isFirstRun()) {
            showIntroSlides()
        } else {
            goToMain()
        }
    }

    private fun showIntroSlides() {
        manager.setFirstRun()

        TODO("NEED TO BE RESOLVE")
        /*val pageOne = SliderPagerBuilder()
            .title(getString(R.string.welcome_title_1))
            .description(getString(R.string.welcome_description_1))
            .imageDrawable(R.drawable.ic_scene2)
            .bgColor(getColor(R.color.base_color))
            .build()

        val pageTwo = SliderPagerBuilder()
            .title(getString(R.string.slide_two_top_text))
            .description(getString(R.string.slide_two_down_text))
            .imageDrawable(R.drawable.notebook_with_logo)
            .bgColor(getColor(R.color.slide_two))
            .build()

        val pageThree = SliderPagerBuilder()
            .title(getString(R.string.slide_three_top_text))
            .description(getString(R.string.slide_three_down_text))
            .imageDrawable(R.drawable.bow_classic_brown)
            .bgColor(getColor(R.color.slide_three))
            .build()

        val pageFour = SliderPagerBuilder()
            .title(getString(R.string.slide_four_top_text))
            .description(getString(R.string.slide_four_down_text))
            .imageDrawable(R.drawable.taget_and_arrow)
            .bgColor(getColor(R.color.slide_four))
            .build()

        addSlide(SlideFragment.newInstance(pageOne))
        addSlide(SlideFragment.newInstance(pageTwo))
        addSlide(SlideFragment.newInstance(pageThree))
        addSlide(SlideFragment.newInstance(pageFour))*/

        showStatusBar(false)
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