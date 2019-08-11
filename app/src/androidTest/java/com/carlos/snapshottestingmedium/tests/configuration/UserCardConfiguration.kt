package com.carlos.snapshottestingmedium.tests.configuration

import com.carlos.snapshottestingmedium.R
import com.carlos.snapshottestingmedium.tests.Variation
import kotlinx.android.synthetic.main.user_card.view.*

class UserCardConfiguration: TestConfiguration(
    "UserCard",
    R.layout.user_card,
    Variation(
        { view, string -> view.name.text = string },"Blanca", "Carlos"
    ),
    Variation(
        { view, string -> view.description.text = string },"Blanca", "Carlos"
    ),
    Variation(
        { view, string -> view.age.text = string }, "Blanca", "Carlos"
    ),
    Variation(
        { view, image -> view.userImage.setImageResource(image) }, R.drawable.daxter, R.drawable.ahri
    )
)