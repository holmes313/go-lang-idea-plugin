package com.goide.stubs.types;

import com.goide.psi.impl.GoFunctionDeclarationImpl;
import com.goide.stubs.GoFunctionDeclarationStub;
import com.intellij.psi.stubs.StubElement;
import com.intellij.psi.stubs.StubInputStream;
import com.intellij.psi.stubs.StubOutputStream;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class GoFunctionDeclarationStubElementType extends GoNamedStubElementType<GoFunctionDeclarationStub, GoFunctionDeclarationImpl> {
  public GoFunctionDeclarationStubElementType(@NotNull String name) {
    super(name);
  }

  @Override
  public GoFunctionDeclarationImpl createPsi(@NotNull GoFunctionDeclarationStub stub) {
    return new GoFunctionDeclarationImpl(stub, this);
  }

  @Override
  public GoFunctionDeclarationStub createStub(@NotNull GoFunctionDeclarationImpl psi, StubElement parentStub) {
    return new GoFunctionDeclarationStub(parentStub, this, psi.getName(), psi.isPublic());
  }

  @Override
  public void serialize(@NotNull GoFunctionDeclarationStub stub, @NotNull StubOutputStream dataStream) throws IOException {
    dataStream.writeName(stub.getName());
    dataStream.writeBoolean(stub.isPublic());
  }

  @NotNull
  @Override
  public GoFunctionDeclarationStub deserialize(@NotNull StubInputStream dataStream, StubElement parentStub) throws IOException {
    return new GoFunctionDeclarationStub(parentStub, this, dataStream.readName(), dataStream.readBoolean());
  }
}