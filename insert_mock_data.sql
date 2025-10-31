-- ============================================
-- Script SQL para inserir dados mockados
-- Categorias e Eventos
-- ============================================

-- ============================================
-- 1. Inserir Categorias
-- ============================================

INSERT INTO categories (name, icon_name, description, created_at, updated_at) VALUES
('Incêndio Florestal', 'fire', 'Eventos relacionados a incêndios florestais e queimadas', NOW(), NOW()),
('Desmatamento', 'tree-felling', 'Desmatamento ilegal e corte de árvores', NOW(), NOW()),
('Poluição', 'factory', 'Poluição do ar, água ou solo em áreas florestais', NOW(), NOW()),
('Caça Ilegal', 'hunting', 'Atividades de caça ilegal na floresta', NOW(), NOW()),
('Invasão Territorial', 'shield-alert', 'Invasões e ocupações ilegais de áreas florestais', NOW(), NOW()),
('Mineração Ilegal', 'pickaxe', 'Exploração mineral não autorizada', NOW(), NOW()),
('Animais em Risco', 'paw', 'Animais silvestres feridos ou em situação de risco', NOW(), NOW()),
('Flora em Risco', 'flower', 'Espécies vegetais ameaçadas ou danificadas', NOW(), NOW());

-- ============================================
-- 2. Inserir um Usuário de Teste (se não existir)
-- ============================================
-- Nota: A senha precisa estar hasheada com BCrypt
-- Exemplo: senha "123456" = $2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iw.kBgUK

INSERT INTO users (name, birthday, email, password, street, neighborhood, city, state, zipcode, address_number, complement, created_at, updated_at, city_hall_id)
VALUES (
    'Usuário Teste',
    '1990-01-15',
    'teste@example.com',
    '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iw.kBgUK', -- senha: 123456
    'Rua das Flores',
    'Centro',
    'São Paulo',
    'SP',
    '01310-100',
    '123',
    'Apto 45',
    NOW(),
    NOW(),
    NULL
) ON CONFLICT (email) DO NOTHING;

-- ============================================
-- 3. Inserir Eventos Mockados
-- ============================================

-- Evento 1: Incêndio Florestal
INSERT INTO events (
    title,
    description,
    status,
    priority,
    street,
    neighborhood,
    city,
    state,
    zipcode,
    address_number,
    latitude,
    longitude,
    category_id,
    user_id,
    created_at,
    updated_at,
    deleted_at
) VALUES (
    'Incêndio em Área de Preservação',
    'Foco de incêndio detectado na Reserva Florestal do Parque Nacional. Área de aproximadamente 50 hectares em risco. Ventos fortes podem espalhar o fogo rapidamente.',
    'ativo',
    'alta',
    'Estrada do Parque',
    'Zona Rural',
    'Campinas',
    'SP',
    '13000-000',
    'S/N',
    -22.906847,
    -47.062633,
    (SELECT id FROM categories WHERE name = 'Incêndio Florestal' LIMIT 1),
    (SELECT id FROM users WHERE email = 'teste@example.com' LIMIT 1),
    NOW(),
    NOW(),
    NULL
);

-- Evento 2: Desmatamento
INSERT INTO events (
    title,
    description,
    status,
    priority,
    street,
    neighborhood,
    city,
    state,
    zipcode,
    address_number,
    latitude,
    longitude,
    category_id,
    user_id,
    created_at,
    updated_at,
    deleted_at
) VALUES (
    'Desmatamento Ilegal na Mata Atlântica',
    'Área de aproximadamente 200 hectares sendo desmatada ilegalmente. Máquinas pesadas foram avistadas no local. Necessária ação imediata das autoridades.',
    'ativo',
    'alta',
    'Rodovia BR-116',
    'Km 145',
    'Sorocaba',
    'SP',
    '18000-000',
    '145',
    -23.501520,
    -47.452613,
    (SELECT id FROM categories WHERE name = 'Desmatamento' LIMIT 1),
    (SELECT id FROM users WHERE email = 'teste@example.com' LIMIT 1),
    NOW() - INTERVAL '2 days',
    NOW() - INTERVAL '2 days',
    NULL
);

-- Evento 3: Poluição
INSERT INTO events (
    title,
    description,
    status,
    priority,
    street,
    neighborhood,
    city,
    state,
    zipcode,
    address_number,
    latitude,
    longitude,
    category_id,
    user_id,
    created_at,
    updated_at,
    deleted_at
) VALUES (
    'Poluição de Rio em Área Florestal',
    'Descarte irregular de resíduos químicos em rio que atravessa área de preservação. Água com coloração anormal e odor forte. Peixes mortos foram encontrados na região.',
    'ativo',
    'média',
    'Margem do Rio',
    'Reserva Biológica',
    'Ribeirão Preto',
    'SP',
    '14000-000',
    'S/N',
    -21.177655,
    -47.810326,
    (SELECT id FROM categories WHERE name = 'Poluição' LIMIT 1),
    (SELECT id FROM users WHERE email = 'teste@example.com' LIMIT 1),
    NOW() - INTERVAL '1 day',
    NOW() - INTERVAL '1 day',
    NULL
);

-- Evento 4: Animais em Risco
INSERT INTO events (
    title,
    description,
    status,
    priority,
    street,
    neighborhood,
    city,
    state,
    zipcode,
    address_number,
    latitude,
    longitude,
    category_id,
    user_id,
    created_at,
    updated_at,
    deleted_at
) VALUES (
    'Onça-pintada Ferida Encontrada',
    'Onça-pintada adulta encontrada com ferimentos nas patas dianteiras. Animal está fraco e necessita de assistência veterinária urgente. Localização próxima a área urbana.',
    'ativo',
    'alta',
    'Estrada da Reserva',
    'Zona Rural',
    'Piracicaba',
    'SP',
    '13400-000',
    'S/N',
    -22.725283,
    -47.648910,
    (SELECT id FROM categories WHERE name = 'Animais em Risco' LIMIT 1),
    (SELECT id FROM users WHERE email = 'teste@example.com' LIMIT 1),
    NOW() - INTERVAL '5 hours',
    NOW() - INTERVAL '5 hours',
    NULL
);

-- Evento 5: Mineração Ilegal
INSERT INTO events (
    title,
    description,
    status,
    priority,
    street,
    neighborhood,
    city,
    state,
    zipcode,
    address_number,
    latitude,
    longitude,
    category_id,
    user_id,
    created_at,
    updated_at,
    deleted_at
) VALUES (
    'Garimpo Ilegal em Área Protegida',
    'Atividade de garimpo ilegal detectada em área de preservação permanente. Escavações e uso de maquinários pesados causando danos irreversíveis ao ecossistema.',
    'ativo',
    'alta',
    'Vale dos Rios',
    'Reserva Legal',
    'São José dos Campos',
    'SP',
    '12200-000',
    'S/N',
    -23.179088,
    -45.887248,
    (SELECT id FROM categories WHERE name = 'Mineração Ilegal' LIMIT 1),
    (SELECT id FROM users WHERE email = 'teste@example.com' LIMIT 1),
    NOW() - INTERVAL '3 days',
    NOW() - INTERVAL '3 days',
    NULL
);

-- Evento 6: Resolvido (para exemplo)
INSERT INTO events (
    title,
    description,
    status,
    priority,
    street,
    neighborhood,
    city,
    state,
    zipcode,
    address_number,
    latitude,
    longitude,
    category_id,
    user_id,
    created_at,
    updated_at,
    deleted_at
) VALUES (
    'Árvore em Risco de Queda - Resolvido',
    'Árvore centenária com risco de queda sobre estrada foi cortada com segurança pela equipe da prefeitura. Local agora está seguro para tráfego.',
    'resolvido',
    'baixa',
    'Rua das Palmeiras',
    'Jardim Botânico',
    'Campinas',
    'SP',
    '13000-000',
    '450',
    -22.910862,
    -47.055674,
    (SELECT id FROM categories WHERE name = 'Flora em Risco' LIMIT 1),
    (SELECT id FROM users WHERE email = 'teste@example.com' LIMIT 1),
    NOW() - INTERVAL '10 days',
    NOW() - INTERVAL '2 days',
    NULL
);

-- ============================================
-- 4. Inserir Imagens para os Eventos (Opcional)
-- ============================================
-- Nota: base64 é muito grande para colar aqui, mas você pode adicionar depois
-- Exemplo de estrutura:

-- INSERT INTO event_images (base64, type, event_id, created_at)
-- VALUES (
--     'data:image/png;base64,iVBORw0KGgoAAAANS...', -- seu base64 aqui
--     'image/png',
--     (SELECT id FROM events WHERE title = 'Incêndio em Área de Preservação' LIMIT 1),
--     NOW()
-- );

-- ============================================
-- VERIFICAÇÃO
-- ============================================

-- Verificar categorias inseridas
SELECT id, name, icon_name FROM categories;

-- Verificar eventos inseridos
SELECT 
    e.id,
    e.title,
    e.status,
    e.priority,
    c.name as categoria,
    u.name as usuario
FROM events e
LEFT JOIN categories c ON e.category_id = c.id
LEFT JOIN users u ON e.user_id = u.id
ORDER BY e.created_at DESC;

