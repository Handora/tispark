/*
 *
 * Copyright 2017 PingCAP, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.pingcap.tikv.txn;

import com.google.protobuf.ByteString;
import com.pingcap.tikv.kvproto.Kvrpcpb;

public class Lock {
  private long txnID;
  private long ttl;
  private ByteString key;
  private ByteString primary;

  public Lock(Kvrpcpb.LockInfo l) {
    txnID = l.getLockVersion();
    key = l.getKey();
    primary = l.getPrimaryLock();
    ttl = l.getLockTtl();
  }

  public long getTxnID() {
    return txnID;
  }

  public void setTxnID(long txnID) {
    this.txnID = txnID;
  }

  public long getTtl() {
    return ttl;
  }

  public void setTtl(long ttl) {
    this.ttl = ttl;
  }

  public ByteString getKey() {
    return key;
  }

  public void setKey(ByteString key) {
    this.key = key;
  }

  public ByteString getPrimary() {
    return primary;
  }

  public void setPrimary(ByteString primary) {
    this.primary = primary;
  }
}
