/*
 * Copyright 2019 IBM All Rights Reserved.
 *
 * SPDX-License-Identifier: Apache-2.0
 */
package org.hyperledger.fabric.contract;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.sameInstance;

import org.hyperledger.fabric.shim.ChaincodeStub;
import org.junit.jupiter.api.Test;

final class ContextTest {

    /** Test creating a new context returns what we expect */
    @Test
    void getInstance() {
        final ChaincodeStub stub = new ChaincodeStubNaiveImpl();
        final Context context1 = new Context(stub);
        final Context context2 = new Context(stub);
        assertThat(context1.getStub(), sameInstance(context2.getStub()));
    }

    /** Test identity created in Context constructor matches getClientIdentity */
    @Test
    void getSetClientIdentity() {
        final ChaincodeStub stub = new ChaincodeStubNaiveImpl();
        final Context context = ContextFactory.getInstance().createContext(stub);
        assertThat(context.getClientIdentity(), sameInstance(context.clientIdentity));
    }
}
