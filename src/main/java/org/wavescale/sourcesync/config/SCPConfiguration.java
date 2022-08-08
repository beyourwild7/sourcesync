package org.wavescale.sourcesync.config;

import org.wavescale.sourcesync.api.ConnectionConfiguration;
import org.wavescale.sourcesync.api.ConnectionConstants;
import org.wavescale.sourcesync.api.PasswordlessSSH;

/**
 * ****************************************************************************
 * Copyright (c) 2014-2107 Faur Ioan-Aurel.                                     *
 * All rights reserved. This program and the accompanying materials             *
 * are made available under the terms of the MIT License                        *
 * which accompanies this distribution, and is available at                     *
 * http://opensource.org/licenses/MIT                                           *
 * *
 * For any issues or questions send an email at: fioan89@gmail.com              *
 * *****************************************************************************
 */
public class SCPConfiguration extends ConnectionConfiguration implements PasswordlessSSH {
    private boolean shouldUseCertificate;
    private boolean shouldUseCertificateWithPassphrase;
    private String certificatePath;

    public SCPConfiguration(String connectionName) {
        super(connectionName);
        this.connectionType = ConnectionConstants.CONN_TYPE_SCP;
        this.port = 22;
        this.workspaceBasePath = "";
        this.host = "scp://";
        this.userName = "";
        this.userPassword = "";
    }

    @Override
    public boolean isPasswordlessSSHSelected() {
        return shouldUseCertificate;
    }

    @Override
    public void setPasswordlessSSHSelected(boolean shouldUseCertificate) {
        this.shouldUseCertificate = shouldUseCertificate;
    }

    @Override
    public boolean isPasswordlessWithPassphrase() {
        return shouldUseCertificateWithPassphrase;
    }

    @Override
    public void setPasswordlessWithPassphrase(boolean shouldUseCertificateWithPassphrase) {
        this.shouldUseCertificateWithPassphrase = shouldUseCertificateWithPassphrase;
    }

    @Override
    public String getCertificatePath() {
        return certificatePath;
    }

    @Override
    public void setCertificatePath(String certificatePath) {
        this.certificatePath = certificatePath;
    }
}
