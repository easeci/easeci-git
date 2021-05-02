package io.easeci.git;

import io.easeci.git.code.GitCodeGenerator;

import io.easeci.extension.command.Command;
import io.easeci.extension.command.CommandParameter;
import io.easeci.extension.command.Directive;
import io.easeci.extension.command.VariableType;
import io.easeci.extension.directive.CodeChunk;

import java.util.Collections;
import java.util.List;

public class GitPerformer implements Directive {

    @Override
    public String getDirectiveName() {
        return "git";
    }

    @Override
    public List<Command> getAvailableCommandList() {
        return List.of(
                Command.of("clone", List.of(
                        CommandParameter.of(VariableType.STRING, "url")
                ))
        );
    }

    @Override
    public CodeChunk provideCode(String parameters) {
        List<Command> commands = Collections.emptyList();
        GitCodeGenerator codeGenerator = new GitCodeGenerator();
        return codeGenerator.generate(commands);
    }
}
