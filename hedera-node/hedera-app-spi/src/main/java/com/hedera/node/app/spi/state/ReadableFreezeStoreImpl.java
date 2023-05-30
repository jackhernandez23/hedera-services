/*
 * Copyright (C) 2023 Hedera Hashgraph, LLC
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

package com.hedera.node.app.spi.state;

import static java.util.Objects.requireNonNull;

import com.swirlds.common.system.DualState;
import edu.umd.cs.findbugs.annotations.NonNull;
import edu.umd.cs.findbugs.annotations.Nullable;
import java.time.Instant;

/**
 * Default implementation of {@link ReadableFreezeStore}.
 */
public class ReadableFreezeStoreImpl implements ReadableFreezeStore {
    /** The underlying data storage class that holds the freeze state data. */
    DualState dualState;

    /**
     * Create a new {@link ReadableFreezeStoreImpl} instance.
     *
     * @param dualState The state to use.
     */
    public ReadableFreezeStoreImpl(@NonNull final DualState dualState) {
        requireNonNull(dualState);

        this.dualState = dualState;
    }

    @Override
    @Nullable
    public Instant freezeTime() {
        return dualState.getFreezeTime();
    }

    @Override
    @Nullable
    public Instant lastFrozenTime() {
        return dualState.getLastFrozenTime();
    }
}
