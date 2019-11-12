package com.carlos.snapshottestingmedium.tests.configuration

import com.carlos.snapshottestingmedium.R
import com.carlos.snapshottestingmedium.tests.Variation
import kotlinx.android.synthetic.main.user_card.view.*

class UserCardConfiguration: TestConfiguration(
    "UserCard",
    R.layout.user_card,
    Variation(
        { view, string -> view.name.text = string },"Ahri", "Chargoggagoggmaggchaubunagungamaugg"
    ),
    Variation(
        { view, string -> view.description.text = string },"Small description", "This is a very very long description with a lot of unnecessary words"
    ),
    Variation(
        { view, string -> view.age.text = string }, "20", "30"
    ),
    Variation(
        { view, image -> view.userImage.setImageResource(image) }, R.drawable.daxter, R.drawable.ahri
    )
)