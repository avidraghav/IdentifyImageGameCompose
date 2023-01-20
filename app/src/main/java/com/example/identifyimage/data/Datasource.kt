/*
 * Copyright (C) 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.identifyimage.data

import com.example.identifyimage.R
import com.example.identifyimage.data.model.ImageData

/**
 * [Datasource] generates a list of [ImageData]
 */

const val SCORE_INCREASE = 10
val images: List<ImageData> =
    listOf<ImageData>(
        ImageData(R.drawable.sun, R.string.sun),
        ImageData(R.drawable.moon, (R.string.moon)),
        ImageData(R.drawable.star, (R.string.star)),
        ImageData(R.drawable.car, (R.string.car)),
        ImageData(R.drawable.bike, (R.string.bike)),
        ImageData(R.drawable.cycle, (R.string.cycle)),
        ImageData(R.drawable.rocket, (R.string.rocket)),
        ImageData(R.drawable.plane, (R.string.plane)),
        ImageData(R.drawable.cap, (R.string.cap)),
        ImageData(R.drawable.calculator, (R.string.calculator))
    )


